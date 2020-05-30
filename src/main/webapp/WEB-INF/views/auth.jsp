  
<c:if test="${loggedinuser != 'anonymousUser'}">
    <span>Dear <strong>${loggedinuser}</strong>welcome and let's start the journey to be inspired everyday!</span>
</c:if>
<c:if test="${loggedinuser == 'anonymousUser'}">
    <span class="text-warning">Get inspired today!</span>
</c:if>
