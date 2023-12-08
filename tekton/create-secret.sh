kubectl create secret docker-registry regcred \
--docker-server=https://index.docker.io/v1/ \
--docker-username={{ (datasource "config").git.username }} \
--docker-password={{ (datasource "config").git.password }} \
--docker-email={{ (datasource "config").git.email }}
-n {{ (datasource "config").k8s.namespace }}