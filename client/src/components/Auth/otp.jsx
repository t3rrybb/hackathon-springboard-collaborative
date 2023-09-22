import { PinInput, Button, Center } from '@mantine/core';
import { useState } from 'react';
import { login } from '../../utils/requests';
import { useLoading } from '../../hooks/useLoading';

export function OTP(props) { 
    const [isValid,setIsValid] = useState(false);
    const { request } = useLoading();
    
    const onChange = (event) => {
        props.setOtp(event);
        console.log(props.otp.length);
        setIsValid(props.otp.length>=5);
    }


    const handleSubmit = async () =>  {
        try {
            const response = await request(() => login({
                mail: props.email,
                otp: props.otp
            }));
            if (response.status === 200) {
              props.setUser(response.data);
              props.navigate('/auth');
              notifications.show({
                title: 'Success',
                color: 'teal',
                message: 'login successfully'
              });
            }
          } catch (error) {
            console.log(error);
          }
      };

    return (
        <>
         <Center>
        <PinInput
            onChange={onChange}
            length={6} type="number"  required />
        </Center>
        <Button onClick={handleSubmit} fullWidth mt="xl" disabled={!isValid}>
         Login
        </Button>
       </>
    )
}