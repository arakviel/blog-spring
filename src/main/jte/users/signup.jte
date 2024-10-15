@param java.util.List<String> validationErrors

<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Форма реєстрації</title>
</head>
<body>

<h1>Реєстрація</h1>

<!-- Виводимо помилки, якщо є -->
@if(validationErrors != null)
    <ul style="color: red;">
        @for(var error : validationErrors)
            <li>${error}</li>
        @endfor
    </ul>
@endif


<!-- Форма реєстрації -->
<form action="/signup" method="post" novalidate>
    <label for="email">Електронна пошта:</label>
    <input type="email" id="email" name="email" required>

    <label for="password">Пароль:</label>
    <input type="password" id="password" name="password" required>

    <label for="roles">Роль користувача:</label>
    <select id="roles" name="role">
        <option value="ROLE_USER">Користувач</option>
        <option value="ROLE_ADMIN">Адміністратор</option>
    </select>

    <button type="submit">Зареєструватися</button>
</form>

</body>
</html>

