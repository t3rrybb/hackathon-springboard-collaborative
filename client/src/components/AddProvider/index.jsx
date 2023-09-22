import { createStyles, Card, Box, TextInput, Center, Title, Button, MultiSelect, FileButton, Group } from '@mantine/core';
import { useState } from 'react';

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

export function AddProvider() {
 const { classes } = useStyles();
 const [name, setName] = useState('');
 const [description, setDescription] = useState('');
 const [email, setEmail] = useState('');
 const [mobileNumber, setMobileNumber] = useState('');
 const [servicesProvided, setServicesProvided] = useState([]);
 const [file, setFile] = useState(null);

 const isFormValid = () => {
    return name && description && email && mobileNumber && servicesProvided.length > 0 && file;
  };

 const handleSubmit = () => {
    if (isFormValid()) {
      // Submit the form data
      console.log('Name:', name);
      console.log('Description:', description);
      console.log('Email:', email);
      console.log('Mobile Number:', mobileNumber);
      console.log('Services Provided:', servicesProvided);
      console.log('File:', file);

      // Reset the form fields if needed
      setName('');
      setDescription('');
      setEmail('');
      setMobileNumber('');
      setServicesProvided([]);
      setFile(null);
    }
  };

  return (
    <>
      <Center>
        <Title slot={2}>Add Providers</Title>
      </Center>
      <Card className={classes.card}>
        <Box className={classes.box}>
          <TextInput
            mt={10}
            label="Name"
            placeholder='Organisation Name'
            value={name}
            onChange={(event) => setName(event.target.value)}
          />
          <TextInput
            mt={10}
            label="Description"
            placeholder='Organisation Description'
            value={description}
            onChange={(event) => setDescription(event.target.value)}
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
            value={mobileNumber}
            onChange={(event) => setMobileNumber(event.target.value)}
          />
          <MultiSelect
            mt={10}
            label="Services Provided"
            placeholder="Pick Service"
            data={['React', 'Angular', 'Vue', 'Svelte']}
            value={servicesProvided}
            onChange={(value) => setServicesProvided(value)}
          />
          <Group mt={20}  justify="center">
            <FileButton fullWidth onChange={setFile} accept="application/pdf">
              {(props) => <Button {...props}>Upload image</Button>}
            </FileButton>
          </Group>
          {file && (
            <Text size="sm" ta="center" mt="sm">
              Picked file: {file.name}
            </Text>
          )}
          <Button fullWidth mt="xl" onClick={handleSubmit} disabled={!isFormValid()}>
            Submit
          </Button>
        </Box>
      </Card>
    </>
  );
}