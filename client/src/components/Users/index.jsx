import {
	createStyles,
	Card,
	List,
	Accordion,
	Button,
	Group,
	Flex,
	Space,
	Container,
	Center,
    Box,
    Title,
    Anchor,
    Avatar,
} from "@mantine/core";

import {  IconList, IconDoor, IconCalendar, IconMail,IconPhone} from '@tabler/icons-react';

const useStyles = createStyles((theme) => ({
	list: {
		listStyleType: "none",
		minWidth: "100%",
        padding: '2rem 4rem',
        [theme.fn.smallerThan(650)]: {
            padding: '1rem 0rem',
        }
	},
    buttons: {
      display: 'flex',
      flexDirection: 'column',
    },
	card: {
        alignItems: 'start',
        minWidth: '100%',
        margin: '1rem 0',
        background: theme.colorScheme === 'dark' ? '#222' : '#fff'
	},

	profile: {
        display: 'flex',
		flexDirection: "row",
		alignItems: "start",
	},

    det: {
        display: 'flex',
        gap: 10,
        margin: '0.5rem 0rem',
        alignItems: 'center',
    },
    bigDet: {
        display: 'flex',
        flexDirection: 'column',
        justifyContent: 'center',
    }
}));

const data = [
	{
		name: "Muhesh",
		email: "mailmuhesh@gmail.com",
		phonenumber: "9790546296",
	},
	{
		name: "Ramesh",
		email: "vms@gmail.com",
		phonenumber: "9790546297",
	},
];
export function Users() {
	const { classes } = useStyles();

    const avatarSizes = {
        small: 70,
        medium: 100,
        large: 120,
      };
    
      // Calculate the size based on the screen width
      const getSize = () => {
        const screenWidth = window.innerWidth;
    
        if (screenWidth < 600) {
          return avatarSizes.small;
        } else if (screenWidth < 1200) {
          return avatarSizes.medium;
        } else {
          return avatarSizes.large;
        }
      };

	return (
        <>
      <Center> <Title>Enrolled Users</Title> </Center> 
		<Accordion 
        variant="separated"
        defaultValue={data[0].email} className={classes.list}>
			{data.map((element) => (
             <Center style={{display: 'flex'}}  >
                             <Accordion.Item
                             className={classes.card}
                              key={element.email} value={element.email}>
                             <Accordion.Control>
                             <Box
								className={classes.profile}
								justify="space-between"
								mt="md"
								mb="xs"
							>
                                <Avatar size="xl"  radius="xl" color="indigo" >{element.name.charAt(0)}</Avatar>
                                
								<Box className={classes.bigDet}  ml={20}>
                                 
                                    <Title order={3}>{element.name}</Title>
                                    <Box className={classes.profile}>
                                        <Box className={classes.det} size="sm" c="dimmed">
                                            <IconDoor/>
                                            cabin1
                                        </Box>
                                        <Anchor ml={20}  href={`telto:${element.email}`}  className={classes.det}  size="sm" c="dimmed">
                                        <IconPhone/>
                                            {element.phonenumber}
                                        </Anchor>
                                
                                    </Box>
                                    <Box className={classes.profile}>
                                    <Anchor href={`mailto:${element.email}`} className={classes.det} size="sm" c="dimmed">
                                                <IconMail/>
                                                {element.email}
                                        </Anchor>
                                    </Box>
                             
                                </Box>
								
							</Box>
                             </Accordion.Control>
                            <Accordion.Panel>
                            <Flex className={classes.buttons} gap="md" >
                              <Box className={classes.det} size="sm" c="dimmed">
                                    <IconCalendar/>
									16/09/2001
								</Box>
                                <Box className={classes.det} size="sm" c="dimmed">
                                    <IconList/>
									service1, service2
								</Box>
							</Flex>
                            </Accordion.Panel>
							

							
                            </Accordion.Item>
                 </Center>
			))}
		</Accordion>
        </>
	);
}
