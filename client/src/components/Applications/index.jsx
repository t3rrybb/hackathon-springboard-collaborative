import {
	createStyles,
	Card,
	List,
	Text,
	Flex,
	Center,
    Box,
    Title,
    Anchor,
    Avatar,
    ActionIcon,
} from "@mantine/core";
import { useLoading } from '../../hooks/useLoading';
import {IconCheck, IconX, IconMail,IconPhone} from '@tabler/icons-react';
import { useEffect, useState } from "react";
import { getApplicants } from "../../utils/requests";

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
      [theme.fn.smallerThan(650)]: {
        flexDirection: 'column',
    }
    },
	card: {
		display: "flex",
		flexDirection: "row",
		justifyContent: "space-between",
        alignItems: 'start',
        minWidth: '100%',
	},

	profile: {
		flexDirection: "column",
		alignItems: "start",
	},

    det: {
        display: 'flex',
        gap: 10,
        margin: '0.5rem 2.5rem',
        alignItems: 'center',
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
export function ApplicationQueue() {
	const { classes } = useStyles();
    const [data, setData] = useState([]);
    const { request } = useLoading();

    const getData = async () => {
        try {
          const response = await request(getApplicants);
          if (response.status === 200) {
            setData(response.data);
          }
        } catch (error) {
           console.log(error);
        }
      };

      
    useEffect(()=>{
      getData()
    },[]);

	return (
        <>
      <Center> <Title>Applicants</Title> </Center> 
		<List className={classes.list}>
			{data.map((element) => (
             <Center style={{display: 'flex'}}  >
						<Card 
                            key={element.id}
                            w='100%'
                            mt={30}
							className={classes.card}
							shadow="sm"
							padding="xs"
							radius="md"
							withBorder
						>
							<Box
                                
								className={classes.profile}
								justify="space-between"
								mt="md"
								mb="xs"
							>
								<Text ml={0} className={classes.det}>
                                    <Avatar radius="xl" color="indigo" >{element.name.charAt(0)}</Avatar>
                                    {element.name}
                                </Text>
								<Anchor href={`mailto:${element.email}`} className={classes.det} size="sm" c="dimmed">
                                    <IconMail/>
									{element.email}
								</Anchor>

								<Anchor  href={`telto:${element.email}`}  className={classes.det}  size="sm" c="dimmed">
                                   <IconPhone/>
									{element.mobileNumber}
								</Anchor>
							</Box>

							<Flex className={classes.buttons} gap="md" >
								<ActionIcon
									variant="light"
									color="green"
									fullWidth
									mt="md"
                                    leftIcon={<IconCheck />}
									radius="md"
								>
                                  <IconCheck />
								</ActionIcon>
								<ActionIcon
									variant="light"
									color="red"
									fullWidth
									mt="md"
									radius="md"
								>
                                   <IconX />
								</ActionIcon>
							</Flex>
						</Card>
                 </Center>
			))}
		</List>
        </>
	);
}
