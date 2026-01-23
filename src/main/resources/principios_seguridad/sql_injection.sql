

public List<AccountDTO> unsafeJpaFindAccountsByCustomerId(String customerId) {
    String jql = "from Account where customerId = '" + customerId + "'";
    TypedQuery<Account> q = em.createQuery(jql, Account.class);
    return q.getResultList()
      .stream()
      .map(this::toAccountDTO)
      .collect(Collectors.toList());
}

Respuesta:

Es vulnerable a inyección SQL porque directamente concatena el parámetro customerId en la cadena de JQL (Java Query Language).
Esto permite a un atacante manipular el parámetro customerId para inyectar código SQL malicioso.

Para mitigar esta vulnerabilidad, debes utilizar una declaración preparada o consulta parametrizada
en lugar de concatenar directamente el parámetro en la cadena de consulta. Aquí tienes una versión actualizada
del código que utiliza una consulta parametrizada:

Alternativa 1: Consulta parametrizada
public List<AccountDTO> safeJpaFindAccountsByCustomerId(String customerId) {
    TypedQuery<Account> q = em.createQuery("from Account where customerId = :customerId", Account.class);
    q.setParameter("customerId", customerId);
    return q.getResultList()
        .stream()
        .map(this::toAccountDTO)
        .collect(Collectors.toList());
}
En este código actualizado, se utiliza el marcador :customerId en la cadena de JQL y se establece el
valor real de customerId utilizando el método setParameter. Esto asegura que el valor de customerId se escape
correctamente y evita ataques de inyección SQL.