import React from 'react';
import {
  ThemeIcon,
  Text,
  Container,
  SimpleGrid,
  useMantineTheme,
  createStyles
} from '@mantine/core';
import {
  IconReportAnalytics, IconDeviceMobileMessage, IconCalculatorOff, IconEye
} from '@tabler/icons';
import PropTypes from 'prop-types';

export const FEATURES = [
  {
    icon: IconReportAnalytics,
    title: 'Mission and Vision',
    description:
        'Springboard\'s primary mission is to help people of all ages and backgrounds achieve their career aspirations by providing them with the skills, confidence, and opportunities they need to enter and progress.'
  },
  {
    icon: IconCalculatorOff,
    title: 'Hospitality, Leisure, and Tourism:',
    description: 'Springboard Charity has a particular focus on these industries, recognizing the wide range of career opportunities they offer and the potential for growth and success within them.'
  },
  {
    icon: IconEye,
    title: 'Impact',
    description:
        'Significant impact on the lives of individuals and the industry it serves. It has helped countless people find meaningful employment, develop careers, and improve their livelihoods.'
  },
  {
    icon: IconDeviceMobileMessage,
    title: 'Mobile App',
    description:
        'The mobile app enable to receive real-time assignments, report incidents, and access critical information on-the-go, increasing efficiency and flexibility.'
  }
];

export function Feature({ icon: Icon, title, description }) {
  const theme = useMantineTheme();
  return (
    <div>
      <ThemeIcon variant="light" size={40} radius={40}>
        <Icon size={20} stroke={1.5} />
      </ThemeIcon>
      <Text style={{ marginTop: theme.spacing.sm, marginBottom: 7 }}>{title}</Text>
      <Text size="sm" color="dimmed" style={{ lineHeight: 1.6 }}>
        {description}
      </Text>
    </div>
  );
}

Feature.propTypes = {
  icon: PropTypes.elementType.isRequired,
  title: PropTypes.string.isRequired,
  description: PropTypes.string.isRequired
};

const useStyles = createStyles((theme) => ({
  wrapper: {
    paddingBottom: 40
  },

  title: {
    fontFamily: `Greycliff CF, ${theme.fontFamily}`,
    fontWeight: 900,
    marginBottom: theme.spacing.md,
    textAlign: 'center',

    [theme.fn.smallerThan('sm')]: {
      fontSize: 28,
      textAlign: 'left'
    }
  },

  description: {
    textAlign: 'center',

    [theme.fn.smallerThan('sm')]: {
      textAlign: 'left'
    }
  }
}));

export function FeaturesGrid() {
  const { classes, theme } = useStyles();
  const features = FEATURES.map((feature) => <Feature {...feature} key={feature.title} />);

  return (
    <Container className={classes.wrapper}>

      <SimpleGrid
        mt={60}
        cols={2}
        spacing={theme.spacing.xl * 2}
        breakpoints={[
          { maxWidth: 980, cols: 2, spacing: 'xl' },
          { maxWidth: 755, cols: 1, spacing: 'xl' }
        ]}
      >
        {features}
      </SimpleGrid>
    </Container>
  );
}
