#version 120

varying vec3 var_color;

void main()
{
	//gl_FragColor = vec4(1.0f, 1.0f, 1.0f, 1.0f);
	gl_FragColor = vec4(var_color, 1.0);
}