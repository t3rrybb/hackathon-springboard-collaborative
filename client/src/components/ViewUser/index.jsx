import { createStyles, Card, Box, TextInput, Center, Title, Button, NumberInput, MultiSelect } from '@mantine/core';
import { DateInput } from '@mantine/dates';
import { useEffect, useState } from 'react';
import { useLoading } from '../../hooks/useLoading';
import { getUser } from '../../utils/requests';
import { useAuth } from '../../hooks/useAuth';


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

export function ViewUser() {
 const { classes } = useStyles();
 const {user} = useAuth();
 const [data, setData] = useState();
 const { request } = useLoading();

 const getData = async () => {
     try {
      data = user
     } catch (error) {
        console.log(error);
     }
   };

    useEffect(()=>{
    getData();
    },[])
 


  return (
    <>
    <Center><Title slot={2}>Participant Profile</Title></Center>
    <Card className={classes.card}>
    <Box className={classes.box}>
      <TextInput
        mt={10}
        disabled
        label="First Name"
        placeholder='First'
        value={data.firstName}

      />
      <TextInput
        mt={10}
        disabled
        label="Last Name"
        placeholder='Last'
        value={data.lastName}

      />
      <TextInput
        mt={10}
        disabled
        label="Email"
        placeholder='you@mantine.dev'
        value={data.email}

      />
      <TextInput
        mt={10}
        disabled
        label="Mobile Number"
        placeholder='999-999-9999'
        value={data.phone}
      />
      <DateInput
        mt={10}
        disabled
        label="Date of Birth"
        placeholder='16/09/1999'
        value={data.dob}
        valueFormat="DD/MM/YYYY"

      />
      <MultiSelect
            mt={10}
            disabled
            label="Services Needed"
            placeholder="Pick Service"
            data={['React', 'Angular', 'Vue', 'Svelte']}
            value={data.need}

        />
      <NumberInput
         mt={10}
         disabled
         label="Cabin Number"
         placeholder='1'
         min={1}
         value={data.cabin}
      />
    </Box>
    </Card>
    </>
  )
}
