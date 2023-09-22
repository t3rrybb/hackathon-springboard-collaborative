import {
   USER_BACKEND_URL,
   AUTH_BACKEND_URL
} from '../config';

export const OTP = `${AUTH_BACKEND_URL}/send-mail`;

export const QUEUE = `${USER_BACKEND_URL}/userQueue`;

export const PARTICIPANT = `${USER_BACKEND_URL}/participants`;

export const USER = `${USER_BACKEND_URL}/user`;

export const PROVIDER = `${AUTH_BACKEND_URL}/service-providers`;