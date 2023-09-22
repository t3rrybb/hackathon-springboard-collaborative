import React from 'react';
import {
  createStyles,
  Container,
  Title,
  Button,
  Group,
  Text
} from '@mantine/core';
import { useNavigate } from 'react-router-dom';

const useStyles = createStyles((theme) => ({
  inner: {
    display: 'flex',
    justifyContent: 'space-between',
    paddingTop: theme.spacing.xl * 4,
    paddingBottom: theme.spacing.xl * 4
  },

  content: {
    maxWidth: 480,
    marginRight: theme.spacing.xl * 3,

    [theme.fn.smallerThan('md')]: {
      maxWidth: '100%',
      marginRight: 0
    }
  },

  title: {
    color: theme.colorScheme === 'dark' ? theme.white : theme.black,
    fontFamily: `Greycliff CF, ${theme.fontFamily}`,
    fontSize: 44,
    lineHeight: 1.2,
    fontWeight: 900,

    [theme.fn.smallerThan('xs')]: {
      fontSize: 28
    }
  },

  control: {
    [theme.fn.smallerThan('xs')]: {
      flex: 1
    }
  },

  image: {
    flex: 1,

    [theme.fn.smallerThan('md')]: {
      display: 'none'
    }
  },

  highlight: {
    position: 'relative',
    backgroundColor: theme.fn.variant({
      variant: 'light',
      color: theme.primaryColor
    }).background,
    borderRadius: theme.radius.sm,
    padding: '4px 12px'
  },

  dots: {
    position: 'absolute',
    color:
      theme.colorScheme === 'dark'
        ? theme.colors.dark[5]
        : theme.colors.gray[1],

    '@media (max-width: 755px)': {
      display: 'none'
    }
  }
}));

export function TopLanding() {
  const navigate = useNavigate();
  const { classes } = useStyles();
  return (
    <div>
      <Container mt={10}>
        <div className={classes.inner}>
          <div className={classes.content}>
            <Title className={classes.title}>
              Empowering Safe Deliveries with
              {' '}
              <span className={classes.highlight}>ePartogram</span>
            </Title>
            <Text color="dimmed" mt="md">
              Experience the Future of Maternal Care with ePartogram - the
              Digital Solution for Better Birth Outcomes.
            </Text>
            <Group mt={30}>
              <Button
                radius="xl"
                size="md"
                className={classes.control}
                onClick={() => navigate('/auth')}
              >
                Join Us
              </Button>
            </Group>
          </div>
          <div className={classes.image}>
            <lottie-player
              autoplay
              loop
              mode="normal"
              src="https://assets2.lottiefiles.com/packages/lf20_nw19osms.json"
            />
          </div>
        </div>
      </Container>
    </div>
  );
}
