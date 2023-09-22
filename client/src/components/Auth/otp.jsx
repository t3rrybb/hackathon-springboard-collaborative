import { PinInput, Button, Center } from '@mantine/core';
import { useState } from 'react';
 
export function OTP(props) { 
    const [isValid,setIsValid] = useState(false);

    const onChange = (event) => {
        props.setOtp(event);
        console.log(props.otp.length);
        setIsValid(props.otp.length>=5);
    }
    return (
        <>
         <Center>
        <PinInput
            onChange={onChange}
            length={6} type="number"  required />
        </Center>
        <Button fullWidth mt="xl" disabled={!isValid}>
         Login
        </Button>
       </>
    )
}