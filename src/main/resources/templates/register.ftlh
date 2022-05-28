<#import "partials/main.ftlh" as main />
<#import "/spring.ftl" as spring />
<@main.renderWith>
    <nav class="navbar navbar-expand-lg bg-light">
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
                    <a class="nav-link"
                       href="http://localhost:8080/find"><@spring.message "search"></@spring.message></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page"
                       href="http://localhost:8080/register"><@spring.message "registration"></@spring.message></a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="http://localhost:8080/login" id="navbarScrollingDropdown"
                       role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <@spring.message "login"></@spring.message>
                    </a>

                </li>
                <form action="/register" method="get">

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
    </nav>

    <div class="container-fluid">

    <h2><@spring.message "please"></@spring.message></h2>
    <div>
        <form action="/register" method="post">
            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
            </#if>

            <div>
                <label class="flex flex-v-center">
                    <p class="label-input-text"><@spring.message "title"></@spring.message></p>
                    <input type="text" name="name" value="${(dto.name)!''}">
                </label>
            </div>
            <div>
                <label class="flex flex-v-center">
                    <p class="label-input-text"><@spring.message "emails"></@spring.message></p>
                    <input type="text" name="email" value="${(dto.email)!''}">
                </label>
            </div>

            <div>
                <label class="flex flex-v-center">
                    <select class="form-select" aria-label="Default select example">
                        <option selected>Role</option>
                        <input type="text" name="role" value="${(dto.role)!''}">


                    </select>
                </label>
            </div>
            <div>
                <label class="flex flex-v-center">
                    <p class="label-input-text"><@spring.message "passwords"></@spring.message></p>
                    <input type="text" name="password" value="">
                </label>
            </div>
            <div>
                <button type="submit"><@spring.message "registration"></@spring.message></button>
            </div>
            <div>
                <#if errors?? >
                    <p>Входные данные с ошибками!</p>
                    <#list errors as fieldError>
                        <p>${fieldError.field} - ${fieldError.defaultMessage!'-- no message --'}</p>
                    </#list>
                </#if>
            </div>
        </form>

        <div class="g-recaptcha" data-sitekey="6LdsZAkgAAAAAJjZQvJKX26hteuO5p06X0cu0rAR"></div>
    </div>
</@main.renderWith>