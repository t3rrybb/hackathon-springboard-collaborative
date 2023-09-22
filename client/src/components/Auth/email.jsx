import {
    TextInput,
    Button,
  } from '@mantine/core';
import { useState } from 'react';
import { useLoading } from '../../hooks/useLoading';
import { sendOTP } from '../../utils/requests';

export function Email(props) { 

   const [isValid, setIsValid]=useState(false);
   const { request } = useLoading();

    const handleSubmit = async () =>  {
        try {
            const response = await request(() => sendOTP({
                mail: props.email
            }));
            if (response.status === 200) {
             props.setStage(1);
              notifications.show({
                title: 'Success',
                color: 'teal',
                message: 'OTP sent successfully'
              });
            }
          } catch (error) {
            console.log(error);
          }
      };

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
        <Button fullWidth mt="xl" onClick={handleSubmit} disabled={!isValid}>
        Send OTP
        </Button>
       </>
    )
}
