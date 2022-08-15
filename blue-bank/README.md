# Blue Bank

Essa aplicação foi desenvolvida para realizar transferências entre corretistas do banco Blue Bank.

# Instruções para deploy da API

Para criação do container docker desse projeto, é necessário você ter préviamente o Docker Engine instalado em seu sistema operacional.

Diante disso, você pode executar os seguintes passos para realizar o deploys da aplicação:

* Execute o arquivo <b>Dockerfile</b> que está em <b>(blue-bank/Dockerfile)</b>.
* Execute o script <b>(blue-bank/docker-image-linux.sh)</b> (caso esteja em um SO Linux) ou o script <b>(blue-bank/docker-image.sh)</b> (caso esteja no SO Windows).
* A pasta <b>(blue-bank/k8s)</b> contém os scrips para deploy e undeploy da aplicação no serviço GKE do Google Cloud Platform.