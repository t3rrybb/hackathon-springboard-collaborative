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
    Badge,
    Tabs,
} from "@mantine/core";
import { useLoading } from '../../hooks/useLoading';
import {IconCheck, IconX, IconMail,IconPhone} from '@tabler/icons-react';
import { useEffect, useState } from "react";
import { getApplicants, updateApplicant } from "../../utils/requests";
import { element } from "prop-types";

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

    side: {
		flexDirection: "column",
		justifyContent: 'space-between',
	},

    det: {
        display: 'flex',
        gap: 10,
        margin: '0.5rem 1rem',
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
    const [queued, setQueued] = useState([]);
    const [approved, setApproved] = useState([]);
    const [rejected, setRejected] = useState([]);
    
    const { request } = useLoading();

    const getData = async () => {
        try {
          const response = await request(getApplicants);
          if (response.status === 200) {
            setData(response.data);
            setApproved(response.data.filter((item)=>item.status==="APPROVED"))
            setRejected(response.data.filter((item)=>item.status==="REJECTED"))
            setQueued(response.data.filter((item)=>item.status==="QUEUED"))
          }
        } catch (error) {
           console.log(error);
        }
      };

      const handleSubmit = async (element,status) =>  {
        try {
            element.status = status;
            const response = await request(() => updateApplicant({
                ...element, 
            }));
            if (response.status === 200) {
              notifications.show({
                title: 'Success',
                color: 'teal',
                message: 'Participant added successfully'
              });
            }
          } catch (error) {
            console.log(error);
            notifications.show({
                title: 'failed',
                color: 'red',
                message: 'Participant adding Failed'
              });
          }
      };
    

      
    useEffect(()=>{
      getData()
    },[]);

	return (
        <>
     <Tabs defaultValue="QUEUED">
      <Tabs.List>
        <Tabs.Tab value="QUEUED">
          Queued
        </Tabs.Tab>
        <Tabs.Tab value="APPROVED">
          Approved
        </Tabs.Tab>
        <Tabs.Tab value="REJECTED">
          Rejected
        </Tabs.Tab>
      </Tabs.List>
            <Tabs.Panel value="QUEUED">
                {queued.map((element,index)=> 
                <ApplicantCard element={element} index={index} classes={classes} handleSubmit={handleSubmit} />)}
            </Tabs.Panel>

            <Tabs.Panel value="APPROVED">
            {approved.map((element,index)=> 
                <ApplicantCard element={element} index={index} classes={classes} handleSubmit={handleSubmit} />)}
            </Tabs.Panel>

            <Tabs.Panel value="REJECTED">
            {rejected.map((element,index)=> 
                <ApplicantCard element={element} index={index} classes={classes} handleSubmit={handleSubmit} />)}
            </Tabs.Panel>
            </Tabs>
        </>
	);
}

function ApplicantCard({element,index, classes,handleSubmit}) {
return (
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
            <Text className={classes.det}>
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
     <Flex className={classes.side}>
         <Badge>{element.status}</Badge>
      {element.status==="QUEUED"?   
      <Flex className={classes.buttons} gap="md" >
            <ActionIcon
                variant="light"
                color="green"
                fullWidth
                mt="md"
                onClick={()=> handleSubmit(element,"APPROVED")}
                radius="md"
            >
              <IconCheck />
            </ActionIcon>
            <ActionIcon
                variant="light"
                color="red"
                fullWidth
                mt="md"
                onClick={()=> handleSubmit(element,"REJECTED")}
                radius="md"
            >
               <IconX />
            </ActionIcon>
        </Flex>:<Box/>}
        </Flex>
    </Card>
</Center>
)

}
