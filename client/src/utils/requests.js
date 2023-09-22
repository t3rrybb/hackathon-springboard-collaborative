import axios from 'axios';

import {
  QUEUE,
  PARTICIPANT,
  OTP,
  USER,
  PROVIDER
} from './urls';


export const sendOTP = async ({mail}) => {
    return axios.get(`${OTP}/${mail}/generateOTP`)
}

export const login = async ({mail,otp}) => {
    return axios.get(`${OTP}/${mail}/${otp}/validateOTP`)
}

export const getApplicants = async () => {
  return axios.get(`${QUEUE}`);
};

export const getProviders = async () => {
    return axios.get(`${PROVIDER}/all`);
};

export const getUser = async ({id}) => {
    return axios.get(`${USER}/${id}`);
}

export const getProvider = async ({id}) => {
    return axios.get(`${PROVIDER}/${id}`);
}
  
export const addApplicants = async ({
    name,
    email,
    mobileNumber
}) => {
    return axios.post(`${QUEUE}`,{
        name,
        email,
        mobileNumber,
        status: 'QUEUED'
    });
  };

export const updateApplicant = async ({
    id,
    name,
    email,
    mobileNumber,
    status
}) => {
    return axios.post(`${QUEUE}`,{
        id,
        name,
        email,
        mobileNumber,
        status
    });
  };
  

export const getParticipants = async () => {
    return axios.get(`${PARTICIPANT}`);
};

export const getUsers = async () => {
    return axios.get(`${USER}/all`);
};
  
export const addParticipant = async ({
    firstName,
    lastName,
    email,
    phone,
    dob,
    cabin,
    need
}) => {
    return axios.post(`${USER}`,{
        firstName,
        lastName,
        email,
        phone,
        dob,
        cabin,
        need,
        status: 'ACTIVE'
    });
  };

  export const addProviders = async ({
    firstName,
    lastName,
    email,
    phone,
    dob,
    cabin,
    need
}) => {
    return axios.post(`${PROVIDER}`,{
        firstName,
        lastName,
        email,
        phone,
        dob,
        cabin,
        need,
        status: 'ACTIVE'
    });
  };

export const uploadFile = async ({
    name,
    formData
}) => {
    return axios.post(`${PROVIDER}/${name}`,
        formData
    , {headers: {
        'Content-Type': 'multipart/form-data',
      }});
  };
  
