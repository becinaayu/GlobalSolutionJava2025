# Sistema de Monitoramento de Queimadas - EcoAlerta

## Integrantes
- Beatriz Dantas Sampaio | RM 554044
- Eduardo Brites Coutinho | RM 552943
- Karolina Araujo Soares | RM 554187
---
## 📝 Introdução
As queimadas são fenômenos que podem ter origens naturais, como a
incidência de raios, caracterizando os chamados incêndios florestais, ou serem
provocadas por ações humanas, a exemplo de queimas controladas que fogem
do controle, fogueiras mal apagadas e até atos intencionais de vandalismo.
Com o agravamento das mudanças climáticas, evidenciado pelo aumento das
temperaturas globais e pela intensificação de períodos de seca prolongada,
observa-se um crescimento tanto na frequência quanto na severidade desses
eventos.
Além de devastarem extensas áreas de vegetação, comprometendo
ecossistemas inteiros e ameaçando a biodiversidade local, as queimadas
liberam grandes volumes de fumaça e partículas tóxicas na atmosfera. Esses
poluentes atmosféricos representam sérios riscos à saúde pública, afetando
não apenas as populações próximas ao foco do incêndio, mas também
comunidades distantes. Isso se deve à dispersão dos poluentes, que pode ser
amplificada por fatores meteorológicos e correntes de ar, ampliando
significativamente a área de impacto e agravando os efeitos socioambientais

## Objetivo
O presente projeto tem como principal objetivo desenvolver uma
aplicação web que funcione como uma ferramenta de monitoramento climático
e prevenção de queimadas, por meio da análise de dados sobre clima e
umidade de diferentes regiões. Busca-se, com isso, antecipar possíveis focos
de incêndio e reduzir seus impactos ambientais e sociais com uma análise em dashboard das ocorrências que foram obtidas.

## 🚀 Funcionalidades

### Dashboard
- Visualização da contagem total de focos de queimadas
- Distribuição de focos por tipo (Fumaça, Calor, Copa, Superficial)
- Gráfico de evolução mensal de focos
- Contagem de agentes ambientais ativos

### Gestão de Focos
- Cadastro de novos focos de queimada
- Classificação por tipo (Fumaça, Calor, Copa, Superficial)
- Registro de coordenadas geográficas (latitude/longitude)
- Registro automático de data e hora

### Gestão de Sensores
- Cadastro e manutenção de sensores
- Associação com regiões monitoradas
- Identificação única por sensor
- Histórico de alertas por sensor

### Gestão de Regiões
- Cadastro de áreas monitoradas
- Associação com sensores
- Definição de perímetros de monitoramento

### Gestão de Agentes Ambientais
- Cadastro de agentes
- Registro de informações de contato

## 💻 Requisitos do Sistema

### Software
- Java JDK 21 ou superior
- Maven 3.6 ou superior
- IntelliJ IDEA ou Eclipse (não é recomendado o uso do: NetBeans)

## 🛠️ Instalação

1. Clone o repositório:
2. Compile e execute o projeto:
3. Acesse a aplicação em: http://localhost:8080
4. Para acessar o console do H2 DataBase em: http://localhost:8080/h2-console 
- Usando os dados: 
- JDBC URL: jdbc:h2:mem:testdb
- User Name: sa
- Password: [vazio]





