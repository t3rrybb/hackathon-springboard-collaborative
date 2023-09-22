import {
  BACKEND_URL
} from '../config';

// auth
export const LOGIN_URL = `${BACKEND_URL}/auth/login`;
export const REGISTER_URL = `${BACKEND_URL}/auth/register`;
export const LOGOUT_URL = `${BACKEND_URL}/auth/logout`;
export const FCM_TOKEN_URL = `${BACKEND_URL}/auth/fcm-token`;
export const USER_URL = `${BACKEND_URL}/user`;

export const GET_ROLES_URL = `${BACKEND_URL}/auth/roles`;
export const ADD_PATIENT_URL = `${BACKEND_URL}/patient/add`;
export const LIST_PATIENTS_URL = `${BACKEND_URL}/patient/list`;
export const GET_PATIENT_URL = `${BACKEND_URL}/patient/`;
export const ADD_MEASUREMENT_URL = `${BACKEND_URL}/patient/addmeasurement`;

export const LIST_ONDUTY_STAFF_URL = `${BACKEND_URL}/user/onduty`;

export const LIST_NEARBY_HOSPITALS_URL = `${BACKEND_URL}/doctor/nearbyhospitals`;

export const HOSPITAL = `${BACKEND_URL}/admin/hospital`;

export const STAFF = `${BACKEND_URL}/admin/staff`;

export const CAPACITY = `${BACKEND_URL}/admin/capacity`;

export const ON_DUTY = `${BACKEND_URL}/admin/onduty`;

export const TRANSFER_PATIENT = `${BACKEND_URL}/patient/transferpatient`;

export const VALIDATE_OTP = `${BACKEND_URL}/send-mail/{mail-id}/{otp}/validateOTP`;

export const SEND_OTP = `${BACKEND_URL}/send-mail/{mail-id}/generateOTP`;

export const QUEUE = `${BACKEND_URL}/userQueue`;

export const PARTICIPANT = `${BACKEND_URL}/participants`;
