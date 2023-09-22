import React from 'react';

import { GeneralPageContainer } from '../containers/GeneralPageContainer';
import { LandingPageContainer } from '../containers/LandingPageContainer';

import { Homepage } from '../components/Home';
import { Form } from '../components/Form';
import { Auth } from '../components/Auth';
import { ApplicationQueue } from '../components/Applications';
import { Users } from '../components/Users';

export const publicRoutes = [
  {
    url: '/auth',
    component: <Auth />,
    name: 'Auth'
  },
  {
    url: '/form',
    component: <Form />,
    name: 'Form'
  },
  {
    url: '/',
    component: <LandingPageContainer />,
    name: 'LandingPageContainer'
  }
];

export const privateRoutes = [
  {
    url: '/home',
    component: <GeneralPageContainer child={<Homepage />} name="Dashboard" />,
    name: 'HomePageContainer',
    label: 'home'
  },
  {
    url: '/applications',
    component: <GeneralPageContainer child={<ApplicationQueue />} name="Queue" />,
    name: 'QueuePageContainer',
    label: 'queue'
  },
  {
    url: '/users',
    component: <GeneralPageContainer child={<Users />} name="Queue" />,
    name: 'UserPageContainer',
    label: 'users'
  }
];
