import smtplib
from email.mime.text import MIMEText
from email.header import Header

sender = 's'
receivers = ['']


msg_body = """
        Dear Donald Trump (特朗普),
        <br>
        <br>

"""
message = MIMEText(msg_body,'html','utf-8')
message['From']= Header('Proview System','utf-8')
message['To'] = Header('Donald Trump (特朗普)','utf-8')

subject = 'CC.'
message['Subject'] = Header(subject,'utf-8')

try:
    smtpObj = smtplib.SMTP('')
    smtpObj.sendmail(sender,receivers,message.as_string())
    print("Send Sucessfully")
except smtplib.SMTPException:
    print("Error: Send Mail")
