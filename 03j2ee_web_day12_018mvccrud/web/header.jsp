<!-- display info -->
<div bgcolor="pink" width="200px">
    <p> user_id :<strong>${pageContext.request.getSession().getAttribute("user_id")}</strong></p>
    <p> captcha :<strong>${pageContext.request.getSession().getAttribute("captcha")}</strong></p>
</div>
