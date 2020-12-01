# notification-service

Spring boot application to send email using AWS .                                                                           

Configure your smtp username and password in application.properties .(src/main/resources/application.properties).                                                                                              

Test Using Postman by below url                                                                                        
REQ: POST                                                           
URL: localhost:8080/notification/notifyByMail                                                               
BODY: RAW - JSON                                                      
{                                                                 
"email_id": "example@gmail.com",                                                          
"mail_subject": "Payment Acknwoledgement",                                                    
"mail_body": "Payment has been received . Thank you !!!"                                                   
