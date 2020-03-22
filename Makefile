SHELL = /bin/bash

.PHONY = startContainer _buildNativeImage _runNativeImage _localDevMode _mvnCleanInstall

help:
	@echo "Usage: "
	@echo -e "\n  Start a native-executable container:"
	@echo "    make startContainer"
	@echo -e "\n  Start on local dev-mode"
	@echo "    make startDevMode"

startContainer: _mvnCleanInstall _buildNativeImage _runNativeImage
startDevMode: _localDevMode

_buildNativeImage:
	@echo "Build native image..."
	@docker build -f Dockerfile.native.multistage -t climate .

_runNativeImage:
	@echo "Run native image..."
	@docker run -i --rm -p 8080:8080 climate

_localDevMode:
	@echo "Start in local dev-mode"
	@mvn compile quarkus:dev

_mvnCleanInstall:
	@echo "Execute maven with goal clean & install"
	@mvn clean install


