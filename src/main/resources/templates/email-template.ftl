<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Welcome to Javapeño</title>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td align="center" valign="top" bgcolor="#838383"
            style="background-color: #838383;"><br> <br>
            <table width="600" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td align="center" valign="top" bgcolor="#d3be6c"
                        style="background-color: #d3be6c; font-family: Arial, Helvetica, sans-serif; font-size: 13px;
                            color: #000000; padding: 0px 15px 10px 15px;">

                        <div style="font-size: 48px; color:blue;">
                            <b>Welcome ${user.name}!</b>
                        </div>

                        <div style="font-size: 14px; color: #555100;">
                            <br> Click the following link to change your generated password <br>
                        </div>

                        <div>
                            <a href="http://localhost:3000/user/change-password/${user.id}">
                                Change my password
                            </a>
                        </div>

                        <div style="font-size: 8px; color: #555100;">
                            <br> Please note, that the link will only be available for 24 hours after receiving this
                            email <br>
                        </div>
                    </td>
                </tr>
            </table>
            <br> <br>
        </td>
    </tr>
</table>
</body>
</html>