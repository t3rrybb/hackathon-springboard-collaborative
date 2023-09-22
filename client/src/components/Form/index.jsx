import {
    createStyles,
    TextInput,
    PasswordInput,
    Checkbox,
    Anchor,
    Paper,
    Title,
    Text,
    Container,
    Group,
    Button,
  } from '@mantine/core';
import { useState } from 'react';
import { HeaderNav } from '../Header';
import { useNavigate } from 'react-router-dom';

const useStyles = createStyles((theme) => ({
    title: {
        fontFamily: 'Greycliff CF, var(--mantine-font-family)',
        fontWeight: 900
      }
  }));
  
export function Form() {
    const { classes } = useStyles();
    const [checked, setChecked] = useState(false);
    const navigate = useNavigate();
    
    return (
        <>
        <HeaderNav/>
        <Container size={420}  my={150}>
      <Title ta="center" className={classes.title}>
        Application Form
      </Title>
      <Text c="dimmed" size="sm" ta="center" mt={5}>
        Already have an account?{' '}
        <Anchor onClick={() => navigate('/auth')} size="sm" component="button">
            Login
        </Anchor>
      </Text>

      <Paper withBorder shadow="md" p={30} mt={30} radius="md">
      <TextInput label="Name" placeholder="Your Name" required mb={10} />
        <TextInput label="Email" placeholder="you@mantine.dev" required mb={10} />
        <TextInput label="Phone Number" placeholder="999-999-9999" required/>
        <Group justify="space-between" mt="lg">
          <Checkbox onChange={(event)=>setChecked(event.target.checked)} label="By ticking this box I consent to the given information being used by TSA" />
        </Group>
        <Button fullWidth mt="xl" disabled={!checked}>
          Submit
        </Button>
      </Paper>
    </Container>
    </>
    )
}