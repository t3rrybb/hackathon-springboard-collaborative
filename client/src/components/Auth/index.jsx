import {
  Paper,
  createStyles,
  Title,
  Text,
  Container,
  Anchor,
} from '@mantine/core';
import { useState } from 'react';
import { Email } from './email';
import { OTP } from './otp';
import { HeaderNav } from '../Header';
import { useNavigate } from 'react-router-dom';

const useStyles = createStyles((theme) => ({
    title: {
        fontSize: 'rem(26px)',
        fontWeight: 900,
        fontFamily: 'Greycliff CF, var(--mantine-font-family)',
      },
      
      controls: {
        [theme.fn.smallerThan('xs')]: {
          flexDirection: 'column-reverse'
        }
      },
      
      control: {
        [theme.fn.smallerThan('xs')]: {
          width: '100%',
          textAlign: 'center'
        }
    }
  }));

export function Auth() {
    const { classes } = useStyles();
    const [email, setEmail] = useState("");
    const [otp, setOtp] = useState("");
    const [stage, setStage] = useState(0);
    const navigate = useNavigate();

    return (
        <>
        <HeaderNav/>
        <Container size={460} my={150}>
        <Title className={classes.title} ta="center">
            Login
        </Title>
        <Text c="dimmed" size="sm" ta="center" mt={5}  mb={30}>
        Don't have an account?{' '}
        <Anchor onClick={() => navigate('/form')} size="sm" component="button">
            Apply
        </Anchor>
        </Text>
        <Text c="dimmed" fz="sm" ta="center">
        Enter the email address or phone number you used to create your profile. Once your identity is confirmed, you will be able to manage your profile.
        </Text>
        <Paper withBorder shadow="md" p={30} radius="md" mt="xl">
            {stage===0?
                <Email email={email} 
                setEmail={setEmail} 
                setStage={setStage}/>:
                <OTP otp={otp} setOtp={setOtp}/>
            }
        </Paper>
        </Container>
        </>
    );
}