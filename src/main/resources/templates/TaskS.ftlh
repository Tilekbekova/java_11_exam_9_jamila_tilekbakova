<#import "partials/main.ftlh" as main />
<#import "/spring.ftl" as spring />
<@main.renderWith>

    <nav class="navbar navbar-expand-lg bg-light">
        <div class="container-fluid">
            <a class="nav-link dropdown-toggle" href="http://localhost:8080"
               id="navbarScrollingDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                <@spring.message "main"></@spring.message>
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll"
                    aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarScroll">
                <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page"
                           href="http://localhost:8080/register"><@spring.message "registration"></@spring.message></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link"
                           href="http://localhost:8080/find"><@spring.message "search"></@spring.message></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="http://localhost:8080/login"
                           id="navbarScrollingDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <@spring.message "login"></@spring.message>
                        </a>

                    </li>
                    <form action="" method="get">

                        <select name="lang" id="lang_select">
                            <option value="en">Us</option>
                            <option value="ru">Ru</option>
                        </select>
                        <button type="submit">
                            <@spring.message "change"></@spring.message>
                        </button>
                    </form>
                </ul>

            </div>
        </div>

    </nav>

    <h1> <@spring.message "categoriess"></@spring.message></h1>
    <h1> <@spring.message "baskets"></@spring.message></h1>
    <#if status??>
       <a href="http://localhost:8080/showTask?status=Backlog"><@spring.message "prices"></@spring.message></a>
        <p>                           </p>
        <a href="http://localhost:8080/showTask?status=Progress"><@spring.message "images"></@spring.message></a>
        <p>                           </p>
        <a href="http://localhost:8080/showTask?status=Done"><@spring.message "delte"></@spring.message></a>
            <#else>
        <h1><@spring.message "noProducts"></@spring.message></h1>
</#if>

<#if dto??>
    <#list dto as product>

        <h2> ${product.user.email}</h2>
        <p>id: <a href="http://localhost:8080/change/${product.id}">${product.id}</a></p>
        <p><@spring.message "title"></@spring.message>: <a href="http://localhost:8080/time/${product.name}">${product.name}</a></p>
        <p><@spring.message "statuss"></@spring.message>: ${product.status}</p>
        <p><@spring.message "dat"></@spring.message>: ${product.localDate}</p>

    <#else>
        <h1><@spring.message "noProducts"></@spring.message></h1>
    </#list>
</#if>

    <#if find??>
        <#list find as product>
            <h1><@spring.message "product"></@spring.message></h1>
            <p> <@spring.message "title"></@spring.message>: ${product.task.name}</p>
            <p> <@spring.message "feedbacks"></@spring.message>: ${product.description}</p>
            <p> <@spring.message "dat"></@spring.message>: ${product.localTime}</p>
            <a href=»/showTask.pdf» download>Скачать файл</a>
        <#else>
            <h1><@spring.message "noProducts"></@spring.message></h1>
        </#list>
    </#if>




</@main.renderWith>









