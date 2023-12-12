# Use patch instead of create to avoid errors if the Secret exists
kubectl patch secret docker-registry regcred \
--docker-server=https://index.docker.io/v1/ \
--docker-username=${{ secrets.GIT_USERNAME }} \
--docker-password=${{ secrets.GIT_PASSWORD }} \
--docker-email=${{ secrets.GIT_EMAIL }}
-n {{ (datasource "config").k8s.namespace }}