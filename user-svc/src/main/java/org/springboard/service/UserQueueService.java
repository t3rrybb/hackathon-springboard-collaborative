package org.springboard.service;

import org.springboard.dao.UserQueueDAO;
import org.springboard.model.UserQueue;
import org.springboard.model.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class UserQueueService {

    @Autowired
    UserQueueDAO userQueueDAO;

    public UserQueue findUserById(String id) {
        return userQueueDAO.findById(id).orElse(null);
    }

    public List<UserQueue> findAllUsers() {
        return userQueueDAO.findAll();
    }

    public List<UserQueue> findUserWithStatus(String status) {
        return userQueueDAO.findByStatus(UserStatus.valueOf(status));
    }

    public List<UserQueue> findUsersWithSpecificStatus(String status) {
        List<UserQueue> userQueueList = new ArrayList<>(findUserWithStatus(status));
        userQueueList.sort(Comparator.comparing(UserQueue::getCreatedDate));
        return userQueueList;
    }

    public UserQueue addUserQueueData(UserQueue userQueue) {
        return userQueueDAO.save(userQueue);
    }

    public String updateQueuedUser(UserQueue queuedUser, String id) {
        var userQueueOld = findUserById(id);
        var stringBuilder = new StringBuilder();
        if (Objects.nonNull(userQueueOld)) {
            stringBuilder.append(updateAndSaveUser(userQueueOld, queuedUser));
        } else {
            stringBuilder.append("No user data found for id : ").append(id);
        }
        return stringBuilder.toString();
    }

    public String deleteQueuedUser(String id) {
        var queuedUserToBeDeleted = findUserById(id);
        var stringBuilder = new StringBuilder();
        if (Objects.isNull(queuedUserToBeDeleted)) {
            stringBuilder.append("User data not found for id : ").append(id);
        } else {
            userQueueDAO.deleteById(id);
            stringBuilder.append("Data is removed successfully for id : ").append(id);
        }
        return stringBuilder.toString();
    }

    private String updateAndSaveUser(UserQueue userQueueOld, UserQueue queuedUser) {
        var queuedUserNewStatus = queuedUser.getStatus().getState();
        var stringBuilder = new StringBuilder();
        var comments = queuedUser.getComments();
        var updateHappened = false;
        if ("REJECTED".equals(queuedUserNewStatus) && ((Objects.nonNull(comments) && comments.trim().isEmpty())
                || (Objects.isNull(comments)))) {
            stringBuilder.append("For rejected user comments are mandatory");
        } else {
            if (Objects.nonNull(queuedUser.getStatus())) {
                userQueueOld.setStatus(queuedUser.getStatus());
                updateHappened = true;
            }
            if (Objects.nonNull(queuedUser.getComments())) {
                userQueueOld.setComments(queuedUser.getComments());
                updateHappened = true;
            }
            if (updateHappened) {
                addUserQueueData(userQueueOld);
                stringBuilder.append("Successfully updated the user data");
            }
        }
        return stringBuilder.toString();
    }
}
