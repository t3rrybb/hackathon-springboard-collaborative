import React, { createContext, useContext, useMemo } from 'react';
import PropTypes from 'prop-types';
import { useLocalStorage } from './useLocalStorage';

const AuthContext = createContext();

export function AuthProvider({ children }) {
   const [user, setUser] = useLocalStorage('user', null);
    if(user) {
        if(user.role === 'TSC'){
            user.tabs = ['queue','users','add-user','add-provider','providers','participant-profile'];
        }else if(user.role === 'Provider'){
            user.tabs = ['users', 'providers'];
        } else {
            user.tabs = ['providers','participant-profile'];
        }
    }

  const value = useMemo(
    () => ({
      user,
    }),
    [user]
  );

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
}

AuthProvider.propTypes = {
  children: PropTypes.node.isRequired
};

export const useAuth = () => useContext(AuthContext);
