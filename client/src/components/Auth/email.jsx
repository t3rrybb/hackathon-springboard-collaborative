import {
    TextInput,
    Button,
  } from '@mantine/core';
import { useState } from 'react';
 
export function Email(props) { 

   const [isValid, setIsValid]=useState(false);

   const onSubmit = () => {
      props.setStage(1);
    }

    const onChange = (event) => {
        props.setEmail(event.currentTarget.value);
        setIsValid(props.email.match(
            /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
          ));
    }
    return (
        <>
        <TextInput
        onChange={onChange}
        value={props.email} label="Email" placeholder="me@mantine.dev" required />
        <Button fullWidth mt="xl" onClick={onSubmit} disabled={!isValid}>
        Send OTP
        </Button>
       </>
    )
}
