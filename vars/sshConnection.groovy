def call(def server)
{
	try {
		sh 'scp target/*.jar springboot@172.31.45.53:/var/springboot/simple-camel-logger-1.0.jar'
		sh """ssh -tt springboot@172.31.45.53 << EOF 
                                sudo systemctl restart simple-camel-logger.service
                                sudo systemctl status simple-camel-logger.service
                                exit
                                EOF"""
	}
	catch(Exception th) {
		echo "issue while copying file"
		throw th;
	}		
}
