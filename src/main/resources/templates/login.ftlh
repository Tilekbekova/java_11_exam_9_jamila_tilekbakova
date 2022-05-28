<#import "partials/main.ftlh" as main/>
<#import "/spring.ftl" as spring/>
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
                           id="navbarScrollingDropdown"
                           role="button" data-bs-toggle="dropdown" aria-expanded="false">
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

    <h2><@spring.message "login"></@spring.message></h2>
    <form action="/login" method="post">

        <div>
            <#if error!false >
                <p style="color:red"><@spring.message "mistake"></@spring.message></p>
            </#if>
        </div>

        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
        </#if>

        <div>
            <label class="flex flex-v-center ">
                <span class="label-input-text"><@spring.message "emails"></@spring.message></span>
                <input type="text" name="username" value="${(dto.email)!''}" autofocus>
            </label>
        </div>
        <div>
            <label class="flex flex-v-center label-input-text">
                <span class="label-input-text"><@spring.message "passwords"></@spring.message></span>
                <input type="text" name="password" value="">
            </label>
        </div>
        <div>
            <button type="submit">Войти!</button>
        </div>
    </form>
    <a href="http://localhost:8080/register"><@spring.message "registrationPlease"></@spring.message></a>


</@main.renderWith>
