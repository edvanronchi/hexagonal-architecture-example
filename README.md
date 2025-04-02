# Hexagonal Architecture Example

A **Arquitetura Hexagonal** (também conhecida como **Ports and Adapters**) é um modelo de design que tem como objetivo **separar a lógica de negócios da infraestrutura**, tornando o código mais modular, flexível e fácil de testar.

### **📌 Princípios da Arquitetura Hexagonal**
1. **Isolamento da Regra de Negócio:**
    - O **código do domínio** não depende de detalhes de implementação como banco de dados ou protocolos de comunicação.
2. **Uso de Ports (Portas) e Adapters (Adaptadores):**
    - **Ports (Interfaces)** → Definem contratos para entrada e saída de dados.
    - **Adapters (Implementações)** → Fazem a ponte entre a lógica de negócio e a infraestrutura.
3. **Facilidade de Testes e Evolução:**
    - Como as regras de negócio estão separadas, é possível **trocar a infraestrutura** (exemplo: trocar um banco SQL por NoSQL) sem alterar o core da aplicação.

---

### **📂 Estrutura do Projeto**
#### **1️⃣ Adapters (Adaptadores)**
- `inbound.controller` → Contém os **controladores REST**, responsáveis por receber requisições externas.
- `outbound.repositories` → Implementação concreta do acesso ao banco de dados (JPA).
- `outbound.messaging` → Publicação e consumo de eventos no **Kafka**.

🔹 **Responsabilidade:** Adaptar diferentes tecnologias para se comunicarem com o domínio.

---

#### **2️⃣ Application (Casos de Uso)**
- `usecase.impl` → Contém a implementação dos casos de uso como `CreateUserUseCaseImpl.java`.
- Os casos de uso chamam os **ports outbound** para acessar dados ou publicar eventos.

🔹 **Responsabilidade:** Orquestrar chamadas entre **regras de negócio** e **infraestrutura**.

---

#### **3️⃣ Domain (Regras de Negócio)**
- `entities` → Contém o modelo de domínio principal (`User.java`).
- `ports` → Define **interfaces** para entrada (`inbound`) e saída (`outbound`).
- `dto` → Representa os objetos de transferência de dados (UserRequestDTO, UserResponseDTO).

🔹 **Responsabilidade:** **Definir o core da aplicação** sem depender de frameworks ou tecnologia específica.

---

### **🎯 Benefícios da Arquitetura**
✅ **Facilidade para trocar tecnologia** → Pode-se mudar o banco de dados ou protocolo de comunicação sem afetar a regra de negócio.  
✅ **Maior testabilidade** → Testes unitários podem ser escritos para os casos de uso sem depender do banco de dados ou APIs externas.  
✅ **Código modular e reutilizável** → Facilita a evolução do projeto sem criar um "monolito difícil de modificar".

---

Essa abordagem **mantém sua aplicação flexível e preparada para crescimento**, permitindo que novos adaptadores (exemplo: APIs GraphQL ou filas RabbitMQ) sejam adicionados sem impactar a lógica central.
