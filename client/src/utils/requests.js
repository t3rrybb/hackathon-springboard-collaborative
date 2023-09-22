import axios from 'axios';
import { getToken } from 'firebase/app-check';

import {
  LOGIN_URL,
  REGISTER_URL,
  LOGOUT_URL,
  USER_URL,
  GET_ROLES_URL,
  ADD_PATIENT_URL,
  LIST_PATIENTS_URL,
  GET_PATIENT_URL,
  ADD_MEASUREMENT_URL,
  LIST_ONDUTY_STAFF_URL,
  LIST_NEARBY_HOSPITALS_URL,
  FCM_TOKEN_URL,
  STAFF,
  CAPACITY,
  ON_DUTY,
  HOSPITAL,
  LIST_STAFFS,
  QUEUE,
  PARTICIPANT
} from './urls';
import { appCheck } from './firebase';

const getIDToken = async () => {
  const idToken = localStorage.getItem('firebase-id-token');
  if (idToken) {
    return new Promise((resolve) => {
      setTimeout(() => {
        resolve(idToken);
      }, 0);
    });
  }
  return null;
};

// requestConfig
const requestConfig = {
  withCredentials: true
};

// auth requests
export const loginRequest = ({ email, password }) => axios.post(
  LOGIN_URL,
  {
    email,
    password
  },
  requestConfig
);

export const registerRequest = ({
  email, name, password, role
}) => getToken(appCheck).then((tokenResult) => axios.post(
  REGISTER_URL,
  {
    email,
    password,
    name,
    role
  },
  {
    ...requestConfig,
    headers: {
      'X-Firebase-AppCheck': tokenResult.token
    }
  }
));

export const logoutRequest = () => axios.get(LOGOUT_URL, requestConfig);

export const userRequest = ({
  token
}) => axios.get(USER_URL, {
  ...requestConfig,
  headers: {
    'X-Token-Firebase': token
  }
});

// roles
export const getRolesRequest = () => axios.get(`${GET_ROLES_URL}`, requestConfig);

// add patient
export const addPatientRequest = async ({
  name,
  age,
  parity,
  alive,
  edd,
  sb,
  nnd,
  riskFactors,
  contractionStartTime,
  membraneRuptureTime,
  height,
  doctor,
  nurse
}) => axios.post(`${ADD_PATIENT_URL}`, {
  name,
  age,
  parity,
  alive,
  edd,
  sb,
  nnd,
  riskFactors,
  contractionStartTime,
  membraneRuptureTime,
  height,
  doctor,
  nurse
}, {
  ...requestConfig,
  headers: {
    'X-Token-Firebase': await getIDToken()
  }
});

// get patient list - done
export const listPatientsRequest = async () => axios.get(`${LIST_PATIENTS_URL}`, {
  ...requestConfig,
  headers: {
    'X-Token-Firebase': await getIDToken()
  }
});

export const getNearbyHospitalsRequest = (token) => axios.get(`${LIST_NEARBY_HOSPITALS_URL}`, {
  ...requestConfig,
  headers: {
    'X-Token-Firebase': token
  }
});

// get patient
export const getPatientRequest = async (id) => axios.get(`${GET_PATIENT_URL}/${id}`, {
  ...requestConfig,
  headers: {
    'X-Token-Firebase': await getIDToken()
  }
});

// add measurement - done
export const addMeasurementRequest = async (
  patientId,
  measurement
) => axios.post(`${ADD_MEASUREMENT_URL}`, {
  patientId,
  ...measurement
}, {
  ...requestConfig,
  headers: {
    'X-Token-Firebase': await getIDToken()
  }
});

// list on onduty staff - done
export const listOnDutyStaffRequest = async () => {
  const token = await getIDToken();
  return axios.get(`${LIST_ONDUTY_STAFF_URL}`, {
    ...requestConfig,
    headers: {
      'X-Token-Firebase': token
    }
  });
};

// fcm token
export const fcmTokenRequest = ({
  token, fcmToken
}) => axios.post(
  FCM_TOKEN_URL,
  { token, fcmToken },
  {
    ...requestConfig,
    headers: {
      'X-Token-Firebase': token
    }
  }
);

export const addHospital = async ({
  name,
  tier,
  lat,
  lon,
  capacity,
  specialist,
  cesarean

}) => {
  const token = await getIDToken();
  return axios.post(`${HOSPITAL}`, {
    name,
    tier,
    lat,
    lon,
    capacity,
    specialist,
    cesarean
  }, {
    ...requestConfig,
    headers: {
      'X-Token-Firebase': token
    }
  });
};

export const getApplicants = async () => {
  return axios.get(`${QUEUE}`);
};

export const addApplicants = async ({
    name,
    email,
    mobileNumber
}) => {
    return axios.post(`${QUEUE}}`,{
        name,
        email,
        mobileNumber,
        status: 'QUEUED'
    });
  };
  

export const getParticipants = async () => {
    return axios.get(`${PARTICIPANT}`);
};

  
export const addParticipant = async ({
    firstName,
    lastName,
    email,
    phone,
    dateOfBirth
}) => {
    return axios.post(`${PARTICIPANT}`,{
        firstName,
        lastName,
        email,
        phone,
        dateOfBirth,
        status: 'ACTIVE'
    });
  };
  
