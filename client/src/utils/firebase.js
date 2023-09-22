import { initializeApp } from 'firebase/app';
import { initializeAppCheck, ReCaptchaV3Provider } from 'firebase/app-check';
import { getMessaging, onMessage } from 'firebase/messaging';
import {
  appCheckDebugToken, firebaseConfig, recaptchaSiteKey
} from '../config';

const app = initializeApp(firebaseConfig);

if (process.env.NODE_ENV === 'development') {
// eslint-disable-next-line no-restricted-globals
  self.FIREBASE_APPCHECK_DEBUG_TOKEN = appCheckDebugToken;
}

const appCheck = initializeAppCheck(app, {
  provider: new ReCaptchaV3Provider(recaptchaSiteKey),
  isTokenAutoRefreshEnabled: true
});

const messaging = getMessaging(app);

onMessage(messaging, () => {
//   console.log('Message received. ', payload);
});

export {
  appCheck, messaging
};
