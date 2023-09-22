import React from 'react';

import { GeneralPageContainer } from '../containers/GeneralPageContainer';
import { AuthPageContainer } from '../containers/AuthPageContainer';
import { LandingPageContainer } from '../containers/LandingPageContainer';

import { Form } from '../components/Form';
import { Auth } from '../components/Auth';
import { ApplicationQueue } from '../components/Applications';
import { Users } from '../components/Users';
import { AddUser } from '../components/AddUser';
import { AddProvider } from '../components/AddProvider';
import { ViewUser } from '../components/ViewUser';
import { Providers } from '../components/Providers';
import { ViewProvider } from '../components/ViewProvider';

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
  },
  {
    url: '/participant-profile',
    component: <GeneralPageContainer child={<ViewUser />} name="Add" />,
    name: 'AddProviderPageContainer',
    label: 'participant-profile'
  },
  {
    url: '/provider-profile',
    component: <GeneralPageContainer child={<ViewProvider />} name="Add" />,
    name: 'AddProviderPageContainer',
    label: 'provider-profile'
  },
  {
    url: '/providers',
    component: <GeneralPageContainer child={<Providers />} name="Providers" />,
    name: 'ProviderPageContainer',
    label: 'providers'
  }
];
