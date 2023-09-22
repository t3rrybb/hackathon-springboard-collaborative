import React from 'react';

import { GeneralPageContainer } from '../containers/GeneralPageContainer';
import { AuthPageContainer } from '../containers/AuthPageContainer';
import { LandingPageContainer } from '../containers/LandingPageContainer';

import { Homepage } from '../components/Home';
import { Form } from '../components/Form';
import { Auth } from '../components/Auth';
import { ApplicationQueue } from '../components/Applications';
import { Users } from '../components/Users';
import { AddUser } from '../components/AddUser';
import { AddProvider } from '../components/AddProvider';

export const publicRoutes = [
  {
    url: '/auth',
    component: <AuthPageContainer child={<Auth />} name="Login"/>,
    name: 'Auth'
  },
  {
    url: '/form',
    component: <AuthPageContainer child={<Form />}  name="Form"/>,
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
    component: <GeneralPageContainer child={<Users />} name="List" />,
    name: 'UserPageContainer',
    label: 'users'
  },
  {
    url: '/add-user',
    component: <GeneralPageContainer child={<AddUser />} name="Add" />,
    name: 'AddUserPageContainer',
    label: 'add-user'
  },
  {
    url: '/add-provider',
    component: <GeneralPageContainer child={<AddProvider />} name="Add" />,
    name: 'AddProviderPageContainer',
    label: 'add-provider'
  }
];
