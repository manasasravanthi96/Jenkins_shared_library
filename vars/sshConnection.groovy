def call(def server)
{
	try {
		sh """ ssh -tt springboot@${server} <<EOF
				sudo systemctl stop simple-camel-logger.service
				exit
		       		EOF"""
		sh 'scp target/*.jar springboot@${server}:/var/springboot/simple-camel-logger-1.0.jar'
		sh """ssh -tt springboot@${server} << EOF 
                                sudo systemctl start simple-camel-logger.service
                                sudo systemctl status simple-camel-logger.service
                                exit
                                EOF"""
	}
	catch(Exception th) {
		echo "issue while copying file"
		throw th;
	}		
}
