def call(def JarFile_name,def host,def destinationPath)
{
	try {
		sh 'scp ${JarFile_name} ${host}:${destinationPath}/${JarFile_name}'
	}
	catch(Exception th) {
		echo "issue while copying file"
		throw th;
	}		
}
