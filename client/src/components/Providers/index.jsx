import {
	createStyles,
	Accordion,
	Center,
    Box,
    Title,
    Anchor,
    Avatar,
} from "@mantine/core";

import {  IconDoor, IconMail,IconPhone} from '@tabler/icons-react';
import { useLoading } from "../../hooks/useLoading";
import { useEffect, useState } from "react";
import { getProviders } from "../../utils/requests";

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

// const data = [
// 	{
// 		name: "Muhesh",
// 		email: "mailmuhesh@gmail.com",
// 		phonenumber: "9790546296",
// 	},
// 	{
// 		name: "Ramesh",
// 		email: "vms@gmail.com",
// 		phonenumber: "9790546297",
// 	},
// ];
export function Providers() {
	const { classes } = useStyles();
    const [data, setData] = useState([]);
    const { request } = useLoading();

    const getData = async () => {
        try {
          const response = await request(getProviders);
          if (response.status === 200) {
            console.log(response.data)
            setData(response.data);
          }
        } catch (error) {
           console.log(error);
        }
      };

    useEffect(()=>{
      getData();
    },[])
    
 

	return (
        <>
      <Center> <Title>Enrolled Providers</Title> </Center> 
		{data.length>0 ?<Accordion 
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
                                <Avatar size="xl"  radius="xl" color="indigo" >{element.name === null?'U': element.name.charAt(0)}</Avatar>
                                
								<Box className={classes.bigDet}  ml={20}>
                                 
                                    <Title order={3}>{element.name}</Title>
                                    <Box className={classes.profile}>
                                        <Box className={classes.det} size="sm" c="dimmed">
                                            <IconDoor/>
                                            {element.website}
                                        </Box>
                                        <Anchor ml={20}  href={`telto:${element.email}`}  className={classes.det}  size="sm" c="dimmed">
                                        <IconPhone/>
                                            {element.phone}
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
							    {element.description}
                            </Accordion.Panel>						
                            </Accordion.Item>
                 </Center>
			))}
		</Accordion>:<Box/>}
        </>
	);
}
