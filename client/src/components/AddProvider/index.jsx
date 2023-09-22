import { createStyles, Card, Box, TextInput, Center, Title, Button, MultiSelect, FileButton, Group, Text } from '@mantine/core';
import { useState } from 'react';
import { useLoading } from '../../hooks/useLoading';
import { addProviders, uploadFile } from '../../utils/requests';

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
 const [website, setWebSite] = useState('');
 const [description, setDescription] = useState('');
 const [email, setEmail] = useState('');
 const [mobileNumber, setMobileNumber] = useState('');
 const [servicesProvided, setServicesProvided] = useState([]);
 const [file, setFile] = useState(null);
 const { request } = useLoading();

 const isFormValid = () => {
    return name && description && email && mobileNumber && servicesProvided.length > 0 && file;
  };

  const handleFileUpload = async (name) => {
    if (file) {
      const formData = new FormData();
      formData.append('consentFile', file);
      try {
        const response = await request(() => uploadFile({
            name,
            formData
        }));
        if (response.status === 200) {
          notifications.show({
            title: 'Success',
            color: 'teal',
            message: 'File uploaded successfully'
          });
        }
      } catch (error) {
        console.log(error);
        if (response.status === 200) {
            notifications.show({
              title: 'Failed',
              color: 'red',
              message: 'File upload Failed'
            });
          }
      }
    }
  };



 const handleSubmit = async () => {
    if (isFormValid()) {
           try {
               const response = await request(() => addProviders({
                   name,
                   website,
                   email,
                   mobileNumber,
                   servicesProvided,
               }));
               if (response.status === 200) {
                handleFileUpload(name);
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
            label="Website"
            placeholder='www.website.com'
            value={website}
            onChange={(event) => setWebSite(event.target.value)}
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
            data={['employment','mental health','medical care','life skills', 'elderly']}
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