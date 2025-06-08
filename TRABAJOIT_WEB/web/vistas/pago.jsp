<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Pagar con Stripe</title>
    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Stripe.js -->
    <script src="https://js.stripe.com/v3/"></script>
    <style>
        .StripeElement {
            background-color: white;
            padding: 10px;
            border: 1px solid #ced4da;
            border-radius: 0.375rem;
        } 

        .StripeElement--focus {
            border-color: #86b7fe;
            box-shadow: 0 0 0 0.25rem rgba(13, 110, 253, 0.25);
        }
    </style>
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">

            <div class="card shadow">
                <div class="card-header bg-primary text-white">
                    <h4 class="mb-0">Pagar con tarjeta</h4>
                </div>
                <div class="card-body">

                    <s:form action="procesarPago" method="post" id="payment-form">
                        <input type="hidden" name="token" id="stripeToken"/>
                        <input type="hidden" name="amount" value="1000" />

                        <div class="mb-3">
                            <label for="card-element" class="form-label">Datos de la tarjeta</label>
                            <div id="card-element" class="form-control">
                                <!-- Stripe injectará aquí la tarjeta -->
                            </div>
                            <div id="card-errors" class="form-text text-danger mt-1"></div>
                        </div>

                        <button type="submit" class="btn btn-success w-100">Pagar 10 €</button>
                    </s:form>

                </div>
            </div>

        </div>
    </div>
</div>

<!-- Stripe setup -->
<script>
    var stripe = Stripe("pk_test_tuClavePublica"); // ← Cambia por tu clave pública
    var elements = stripe.elements();
    var card = elements.create("card");
    card.mount("#card-element");

    var form = document.getElementById("payment-form");
    form.addEventListener("submit", function(event) {
        event.preventDefault();
        stripe.createToken(card).then(function(result) {
            if (result.error) {
                document.getElementById("card-errors").textContent = result.error.message;
            } else {
                document.getElementById("stripeToken").value = result.token.id;
                form.submit();
            }
        });
    });
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>