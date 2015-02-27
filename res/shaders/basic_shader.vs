#version 330 core

layout(location = 0) in vec3 in_position;
layout(location = 1) in vec2 in_texCoord;

out vec2 pass_texCoord;
out vec3 pass_color;

uniform mat4 u_transform;
uniform mat4 u_projection;

void main()
{
	pass_texCoord = in_texCoord;
	pass_color = clamp(in_position, 0.0, 1.0);

	gl_Position = u_projection * u_transform * vec4(in_position, 1.0f);
}