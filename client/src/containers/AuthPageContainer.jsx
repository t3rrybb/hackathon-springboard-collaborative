import React, { useEffect } from 'react';
import { useLocation } from 'react-router-dom';

export function AuthPageContainer({child}) {
  const location = useLocation();
  useEffect(() => {
    window.gtag('event', 'page_view', {
      page_title: 'Auth Page',
      page_path: location.pathname + location.search,
      page_location: window.location.href
    });
  }, [location]);
  return (
    <div>
      {child}
    </div>
  );
}
