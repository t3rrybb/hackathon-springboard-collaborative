import {
  IconHome,
  IconForms,
  IconUsers,
  IconPlus,
  IconUserPlus,
  IconBuildingCommunity,
  IconUserCircle
} from '@tabler/icons';

export const navLinks = [
  {
    link: '/home', label: 'home', icon: IconHome, name: 'Dashboard'
  },
  {
    link: '/applications', label: 'queue', icon: IconForms, name: 'Applications'
  },
  {
    link: '/add-user', label: 'add-user', icon: IconUserPlus, name: 'Add User'
  },
  {
    link: '/users', label: 'users', icon: IconUsers, name: 'Users'
  },
  {
    link: '/add-provider', label: 'add-provider', icon: IconPlus, name: 'Add Provider'
  },
  {
    link: '/providers', label: 'providers', icon: IconBuildingCommunity, name: 'Providers'
  },
  {
    link: '/participant-profile', label: 'participant-profile', icon: IconUserCircle, name: 'Profile'
  },
];
