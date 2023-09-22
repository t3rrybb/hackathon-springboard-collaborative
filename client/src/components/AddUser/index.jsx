import { createStyles, Card, Box, TextInput, Center, Title, Button, NumberInput } from '@mantine/core';
import { DateInput } from '@mantine/dates';
import { notifications } from '@mantine/notifications';
import { useState } from 'react';
import { useLoading } from '../../hooks/useLoading';
import { addParticipant } from '../../utils/requests';

const useStyles = createStyles((theme) => ({
	card: {
        margin: '2rem 4rem',
        [theme.fn.smallerThan(650)]: {
            margin: '2rem 1rem',
        }
	},
    box: {
        padding: '1rem 2rem',
        [theme.fn.smallerThan(650)]: {
            padding: '1rem',
        }
	},
}));

export function AddUser() {
 const { classes } = useStyles();
 
 const [firstName, setFirstName] = useState('');
 const [lastName, setLastName] = useState('');
 const [email, setEmail] = useState('');
 const [phone, setMobileNumber] = useState('');
 const [dateOfBirth, setDateOfBirth] = useState('');
 const [cabinNumber, setCabinNumber] = useState(0);

 const { request } = useLoading();

 const handleSubmit = async () =>  {
    try {
        const response = await request(() => addParticipant({
            firstName,
            lastName,
            email,
            phone,
            dateOfBirth
        }));
        if (response.status === 200) {
          notifications.show({
            title: 'Success',
            color: 'teal',
            message: 'Participant added successfully'
          });
        }
      } catch (error) {
        console.log(error);
      }
  };


  return (
    <>
    <Center><Title slot={2}>Add Participants</Title></Center>
    <Card className={classes.card}>
    <Box className={classes.box}>
      <TextInput
        mt={10}
        label="First Name"
        placeholder='First'
        value={firstName}
        onChange={(event) => setFirstName(event.target.value)}
      />
      <TextInput
        mt={10}
        label="Last Name"
        placeholder='Last'
        value={lastName}
        onChange={(event) => setLastName(event.target.value)}
      />
      <TextInput
        mt={10}
        label="Email"
        placeholder='you@mantine.dev'
        value={email}
        onChange={(event) => setEmail(event.target.value)}
      />
      <TextInput
        mt={10}
        label="Mobile Number"
        placeholder='999-999-9999'
        value={phone}
        onChange={(event) => setMobileNumber(event.target.value)}
      />
      <DateInput
        mt={10}
        label="Date of Birth"
        placeholder='16/09/1999'
        value={dateOfBirth}
        valueFormat="DD/MM/YYYY"
        onChange={(value) => setDateOfBirth(value)}
      />
      <NumberInput
         mt={10}
         label="Cabin Number"
         placeholder='1'
         min={1}
         value={cabinNumber}
         onChange={(event) => setCabinNumber(event)}
      />
      <Button fullWidth mt="xl" onClick={handleSubmit}>Submit</Button>
    </Box>
    </Card>
    </>
  )
}
