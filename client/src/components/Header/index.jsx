import React from 'react';
import {
  createStyles, Header, Container, Group, UnstyledButton, Text, Center,
  useMantineColorScheme, Burger, Paper, MediaQuery, useMantineTheme, ActionIcon
  // Transition
} from '@mantine/core';
import { IconMoon, IconSun } from '@tabler/icons';
import PropTypes from 'prop-types';
import { useLocation, useNavigate } from 'react-router-dom';
import logo from './logo-new.png';

const HEADER_HEIGHT = 70;

const useStyles = createStyles((theme) => ({
  root: {
    position: 'fixed',
    zIndex: 1
  },

  dropdown: {
    position: 'absolute',
    top: HEADER_HEIGHT,
    left: 0,
    right: 0,
    zIndex: 0,
    borderTopRightRadius: 0,
    borderTopLeftRadius: 0,
    borderTopWidth: 0,
    overflow: 'hidden',

    [theme.fn.largerThan('sm')]: {
      display: 'none'
    }
  },

  header: {
    display: 'flex',
    alignItems: 'center',
    height: '100%',
    maxWidth: '100%',
    padding: 0,
    margin: 0,
    [theme.fn.largerThan('sm')]: {
      justifyContent: 'space-between'
    }
  },

  links: {
    [theme.fn.smallerThan('sm')]: {
      display: 'none'
    }
  },

  burger: {
    [theme.fn.largerThan('sm')]: {
      display: 'none'
    }
  },

  link: {
    display: 'block',
    lineHeight: 1,
    padding: '8px 12px',
    borderRadius: theme.radius.sm,
    textDecoration: 'none',
    color: theme.colorScheme === 'dark' ? theme.colors.dark[0] : theme.colors.gray[7],
    fontSize: theme.fontSizes.sm,
    fontWeight: 500,

    '&:hover': {
      backgroundColor: theme.colorScheme === 'dark' ? theme.colors.dark[6] : theme.colors.gray[0]
    },

    [theme.fn.smallerThan('sm')]: {
      borderRadius: 0,
      padding: theme.spacing.md
    }
  },

  linkActive: {
    '&, &:hover': {
      backgroundColor: theme.fn.variant({ variant: 'light', color: theme.primaryColor }).background,
      color: theme.fn.variant({ variant: 'light', color: theme.primaryColor }).color
    }
  },

  control: {
    backgroundColor: theme.colorScheme === 'dark' ? theme.colors.dark[8] : theme.colors.gray[0],
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'space-between',
    borderRadius: 1000,
    paddingLeft: theme.spacing.sm,
    paddingRight: 4,
    width: 136,
    height: 36
  },

  iconWrapper: {
    height: 28,
    width: 28,
    borderRadius: 28,
    backgroundColor: theme.colorScheme === 'dark' ? theme.colors.yellow[4] : theme.colors.dark[4],
    color: theme.colorScheme === 'dark' ? theme.black : theme.colors.blue[2]
  },

  value: {
    lineHeight: 1
  },

  flexer: {
    display: 'flex'
  }
}));

export function HeaderNav({ opened: open, setOpened }) {
  const { classes } = useStyles();
  const { colorScheme, toggleColorScheme } = useMantineColorScheme();
  const Icon = colorScheme === 'dark' ? IconMoon : IconSun;
  const navigate = useNavigate();

  const theme = useMantineTheme();

  const items = (
      <Center className={classes.iconWrapper}>
        <ActionIcon onClick={() => toggleColorScheme()}>
        <Icon size={18} stroke={1.5} />
        </ActionIcon>
      </Center>
  );

  const location = useLocation();

  return (
    <Header height={HEADER_HEIGHT} className={classes.root} p="md">
      <Container className={classes.header}>
        {open
        && (

          // <Transition duration={200} mounted={open} transition="fade" timingFunction="ease">
          //   {(styles) => (
          <Paper className={classes.dropdown} withBorder>
            {items}
          </Paper>
          //  )}
          // </Transition>
        ) }
        {(location.pathname !== '/' && location.pathname !== '/auth')
        && (
          <MediaQuery largerThan="sm" styles={{ display: 'none' }}>
            <Burger
              opened={open}
              onClick={() => setOpened((o) => !o)}
              size="sm"
              color={theme.colors.gray[6]}
              mr="xl"
            />
          </MediaQuery>
        ) }
        <UnstyledButton className={classes.flexer} onClick={() => navigate('/')}>
          <img src={logo} height={40} alt="logo" />
        </UnstyledButton>
        <Group spacing={5} className={classes.links}>
          {items}
        </Group>

      </Container>
    </Header>
  );
}

HeaderNav.propTypes = {
  opened: PropTypes.bool.isRequired,
  setOpened: PropTypes.func.isRequired
};
