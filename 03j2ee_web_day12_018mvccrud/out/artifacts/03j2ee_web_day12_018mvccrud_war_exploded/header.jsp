<!-- display info -->
<div style="color:red">
    <p> <strong>user_id</strong>:<strong color="red">${pageContext.request.getSession().getAttribute("user_id")}</strong></p>
    <p> <strong>captcha</strong> :<strong color="red">${pageContext.request.getSession().getAttribute("captcha")}</strong></p>
</div>
