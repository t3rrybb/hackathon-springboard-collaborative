import { createStyles, Card, Box, TextInput, Center, Title, Button, MultiSelect, FileButton, Group, Text } from '@mantine/core';
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

export function ViewProvider() {
 const { classes } = useStyles();
 const {user} = useAuth();

  return (
    <>
      <Center>
        <Title slot={2}>Provider Profile</Title>
      </Center>
      <Card className={classes.card}>
        <Box className={classes.box}>
          <TextInput
            mt={10}
            label="Name"
            placeholder='Organisation Name'
            value={user.name}
          />
        <TextInput
            mt={10}
            label="Website"
            placeholder='www.website.com'
            value={user.website}
          />
          <TextInput
            mt={10}
            label="Description"
            placeholder='Organisation Description'
            value={user.description}
          />
          <TextInput
            mt={10}
            label="Email"
            placeholder='you@mantine.dev'
            value={user.email}
          />
          <TextInput
            mt={10}
            label="Mobile Number"
            placeholder='999-999-9999'
            value={user.mobileNumber}
          />
          <MultiSelect
            mt={10}
            label="Services Provided"
            placeholder="Pick Service"
            data={['employment','mental health','medical care','life skills', 'elderly']}
            value={servicesProvided}
          />
        </Box>
      </Card>
    </>
  );
}