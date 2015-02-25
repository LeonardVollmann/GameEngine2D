#version 120

attribute vec3 in_position;

varying vec3 var_color;

uniform float u_clampValue;

void main()
{
	var_color = clamp(in_position, 0, u_clampValue);
	gl_Position = vec4(in_position, 1.0f);
}